package ru.egar.production_calendar_csv_parser.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * сущность производственного календаря содержит дату и тип дня,
 * учитываются только выходные, праздничные и сокращённые дни
 */
@Entity
@Table(name = "weekends")
@Getter
@Setter
@NoArgsConstructor
public class WeekendAndShortDays {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date", columnDefinition = "timestamp")
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(16)")
    private DayType dayType;

    public WeekendAndShortDays(LocalDate date, DayType dayType) {
        this.date = date;
        this.dayType = dayType;
    }
}

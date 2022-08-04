package com.nhnacademy.batch.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "batch_read_first")
public class BatchReadFirst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "batch_read_no")
    Integer no;
    @NotNull
    Integer point;
    @NotNull
    Integer weight;
    Integer result;

    public void setResult(Integer result) {
        this.result = result;
    }
}

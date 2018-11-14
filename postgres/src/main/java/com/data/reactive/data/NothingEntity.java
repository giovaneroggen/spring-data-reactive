package com.data.reactive.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("nothing")
@NoArgsConstructor
@AllArgsConstructor
public class NothingEntity {

    @Id
    private Long id;
    private String name;

}

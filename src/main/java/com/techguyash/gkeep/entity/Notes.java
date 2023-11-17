package com.techguyash.gkeep.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Notes
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    private boolean trashed=false;
    private boolean archived=false;
}

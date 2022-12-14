package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "recovery_room")
public class RecoveryRoom extends BaseEntity{

    @NotNull
    @Size(min = 3, max = 50)
    String name;

    @NotNull
    @Min(value = 0)
    double size;

    boolean secure;

    @ManyToOne
    @JoinColumn(name="recovery_room_type_id")
    RecoveryRoomType roomType;
}

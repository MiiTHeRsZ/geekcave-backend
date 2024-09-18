package gusta.miithersz.geekcave.models;

import gusta.miithersz.geekcave.dto.requests.DTOFranchiseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Franchise")
@Table(name = "franchise")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "franchiseId")
public class FranchiseModel {

    public FranchiseModel(DTOFranchiseModel franchise) {
        this.franchiseId = franchise.franchiseId();
        this.franchiseName = franchise.franchiseName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franchise_id")
    private Long franchiseId;

    @Column(name = "franchise_name")
    private String franchiseName;

}

package ru.dev.bottled.cola.hackathon.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String email;
    private String hashPassword;
    private String avatar;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    @Setter(AccessLevel.NONE)
    private Profile profile;

    public void setProfile(Profile profile) {
        updateProfile(profile, true);
    }

    void updateProfile(Profile profile, boolean set) {
        if (profile != null) {
            this.profile = profile;
            if (set) {
                profile.updateUser(this, false);
            }
        }
    }
}

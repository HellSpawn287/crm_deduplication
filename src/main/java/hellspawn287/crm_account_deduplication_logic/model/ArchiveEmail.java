package hellspawn287.crm_account_deduplication_logic.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "archive_Emails")
public class ArchiveEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_archive")
    private Integer id;

    @NotNull
    private String archive;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_account", nullable = false)
    private OldAccount account;

    public ArchiveEmail() {
    }

    public ArchiveEmail(String archive) {
        this.archive = archive;
    }

    public String getArchive() {
        return archive;
    }

    public void setArchive(String archive) {
        this.archive = archive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArchiveEmail)) return false;
        ArchiveEmail that = (ArchiveEmail) o;
        return archive.equals(that.archive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archive);
    }
}

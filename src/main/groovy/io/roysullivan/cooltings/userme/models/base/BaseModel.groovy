package io.roysullivan.cooltings.userme.models.base
import java.time.Instant

class BaseModel {
    private UUID id

    private Date dateCreated

    private Date dateLastAccess

    private Date dateModified

    BaseModel() {
        this.setId(UUID.randomUUID())

        this.setDateCreated(Date.from(Instant.now()))
        this.setDateModified(Date.from(Instant.now()))
        this.setDateLastAccess(Date.from(Instant.now()))
    }

    UUID getId() {
        return id
    }

    void setId(UUID id) {
        this.id = id
    }

    Date getDateCreated() {
        return dateCreated
    }

    void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated
    }

    Date getDateLastAccess() {
        return dateLastAccess
    }

    void setDateLastAccess(Date dateLastAccess) {
        this.dateLastAccess = dateLastAccess
    }

    Date getDateModified() {
        return dateModified
    }

    void setDateModified(Date dateModified) {
        this.dateModified = dateModified
    }

    @Override
    String toString() {
        return """\
    BaseModel -> {
        id=$id,
        dateCreated=$dateCreated,
        dateLastAccess=$dateLastAccess,
        dateModified=$dateModified
    }"""
    }
}

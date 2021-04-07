package hibernate.lesson11.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

    /*@SequenceGenerator - аннотация позволяет описать свой генератор значений для поля ID
    * У него есть несколько параметров:
    * - name - имя генератора на уровне программы
    * - sequenceName - имя генератора на уровне БД
    * - initialValue - начальное значение
    * - allocationSize - шаг, на который будет изменено значение
    * @GeneratedValue - позволяет подключить генератор (SEQUENCE)*/
    @Id
    @Column(name = "author_id")
    @SequenceGenerator(name = "authorId", sequenceName = "seq_author_id", initialValue = 20180000, allocationSize = 25)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorId")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "author", targetEntity = Book.class)
    private Book book;

    public Author() {}

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

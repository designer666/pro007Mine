package hibernate.lesson11.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id")
    @SequenceGenerator(name = "bookId", sequenceName = "seq_book_id", initialValue = 16150000, allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookId")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date publishDate;

    /*@OneToOne - позволяет нам установить связь между записью из таблицы Books к таблице Authors. Соотношение Один-к-Одному
    * -fetch - тип выборки данных
    *   FetchType.LAZY  - ленивая выборка данных. Данные предоставляются по мере необходимости. Минус - частые запросы к БД
    *   FetchType.EAGER - полная выборка данных. Данные предоставляются в полном объеме. Минус - предоставляются данные, которые не понадобятся
    * @JoinColumn - позволяет настроить связующее поле в таблице БД
    * -name - имя столбца в текущей таблице
    * -referencedColumnName - имя столбца во внешней таблице, по которому будет установлена связь
    * */
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Author.class)
    @JoinColumn(name = "authorId", referencedColumnName = "author_id")
    private Author author;

    public Book() {
    }

    public Book(String title, String description, Date publishDate) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", publishDate=").append(publishDate);
        sb.append('}');
        return sb.toString();
    }
}

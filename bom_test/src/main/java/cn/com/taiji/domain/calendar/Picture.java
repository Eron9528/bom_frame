package cn.com.taiji.domain.calendar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PICTURE")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FILENAME")
    private String fileName;
    @Column(name = "URL")
    private String url;
    @Column(name = "CONTENT")
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] content;
    @Column(name = "UPLOAD_TIME")
    private LocalDateTime uploadTime;
}

package com.sparta.team9back.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name="postLike_uk",
                        columnNames = {"post_id", "user_id"}
                )
        }
)
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postLikeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    //@JsonIgnoreProperties({"postList"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public PostLike(Post post, User user) {
        this.post = post;
        this.user = user;
    }
}

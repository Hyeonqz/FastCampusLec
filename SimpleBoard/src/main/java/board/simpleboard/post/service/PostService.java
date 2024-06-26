package board.simpleboard.post.service;

import board.simpleboard.bboard.repository.BoardRepository;
import board.simpleboard.common.Api;
import board.simpleboard.common.Pagination;
import board.simpleboard.post.db.PostEntity;
import board.simpleboard.post.model.PostRequestDTO;
import board.simpleboard.post.model.PostViewRequest;
import board.simpleboard.post.repository.PostRepository;
import board.simpleboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final ReplyService replyService;

    public PostEntity create(PostRequestDTO postRequestDTO) {

        var boardEntity = boardRepository.findById(postRequestDTO.getBoardId());
        var entity = PostEntity.builder()
                .board(boardEntity.get())
                .userName(postRequestDTO.getUserName())
                .password(postRequestDTO.getPassword())
                .email(postRequestDTO.getEmail())
                .status("REGISTERED")
                .title(postRequestDTO.getTitle())
                .content(postRequestDTO.getContent())
                .postedAt(LocalDateTime.now())
                .build();
        return postRepository.save(entity);
    }

    public PostEntity view(PostViewRequest postViewRequest) {
        // 게시글이 있는가?
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(),"REGISTERED")
                .map( it -> {
                    if(!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다 기존 : %s vs 입력 : %s";
                        throw new RuntimeException(String.format(format,it.getPassword(), postViewRequest.getPassword()));
                    }
                    return it;

                }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시글이 존재하지 않습니다. : " + postViewRequest.getPostId());
                        }
                );
        // 비밀번호가 맞는가?
    }

    public Api<List<PostEntity>> all(Pageable pageable) {
        var list = postRepository.findAll(pageable);

        var pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalElements(list.getTotalElements())
                .totalPage(list.getTotalPages())
                .build();

        var response = Api.<List<PostEntity>>builder()
                .body(list.toList())
                .pagination(pagination)
                .build();


        return response;
    }

    public void delete(PostViewRequest postViewRequest) {
         postRepository.findById(postViewRequest.getPostId())
                .map( it -> {
                    if(!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다. 기존 :  %s vs  입력 : %s";
                        throw new RuntimeException(String.format(format,it.getPassword(), postViewRequest.getPassword()));
                    }
                    it.setStatus("UNREGISTERED");
                    postRepository.save(it);
                    return it;
                }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시글이 존재하지 않습니다. : " + postViewRequest.getPostId());
                        }
                );
    }

}

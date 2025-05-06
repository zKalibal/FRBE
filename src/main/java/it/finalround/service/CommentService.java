
package it.finalround.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import jakarta.persistence.EntityNotFoundException;
import it.finalround.entity.*;
import it.finalround.repository.*;

@Service
@RequiredArgsConstructor
public class CommentService {
   private final CommentRepository commentRepo;
   private final ArticleRepository articleRepo;
   private final CommentLikeRepository likeRepo;

   public Page<Comment> list(Long postId, Pageable pageable){
       Article post = articleRepo.findById(postId)
               .orElseThrow(() -> new EntityNotFoundException("Post not found"));
       return commentRepo.findByPostAndParentIsNullOrderByDateDesc(post,pageable);
   }

   public Comment add(Long postId, String body, Long userId, Long parentId){
       Article post = articleRepo.findById(postId)
               .orElseThrow(()->new EntityNotFoundException("Post not found"));
       Comment parent = null;
       if(parentId!=null){
           parent = commentRepo.findById(parentId)
                   .orElseThrow(()->new EntityNotFoundException("Parent comment not found"));
       }
       Comment c = Comment.builder()
               .post(post)
               .parent(parent)
               .userId(userId)
               .comment(body)
               .build();
       return commentRepo.save(c);
   }

   public Comment toggleLike(Long commentId, Long userId, int type){
       Comment c = commentRepo.findById(commentId)
               .orElseThrow(()->new EntityNotFoundException("Comment not found"));
       var existing = likeRepo.findByCommentIdAndUserId(commentId,userId);
       if(existing.isPresent()){
           CommentLike cl = existing.get();
           if(cl.getType()==type){
               likeRepo.delete(cl); // unlike
           }else{
               cl.setType(type);
               likeRepo.save(cl);
           }
       }else{
           likeRepo.save(CommentLike.builder()
                   .comment(c).userId(userId).type(type).build());
       }
       return c;
   }
}


package it.finalround.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import it.finalround.repository.*;
import it.finalround.entity.*;

@Service
@RequiredArgsConstructor
public class FavoriteService {

   private final FavoriteRepository favRepo;
   private final ArticleRepository articleRepo;

   public void toggle(Long postId, Long userId){
      Article post = articleRepo.findById(postId)
        .orElseThrow(()->new EntityNotFoundException("Post not found"));
      var existing = favRepo.findByPostIdAndUserId(postId,userId);
      if(existing.isPresent()){
         favRepo.delete(existing.get());
      }else{
         favRepo.save(Favorite.builder().post(post).userId(userId).build());
      }
   }

   public java.util.List<Article> listFavorites(Long userId){
      return favRepo.findByUserId(userId).stream().map(Favorite::getPost).toList();
   }

   public long countFavorites(Article post){
      return favRepo.countByPost(post);
   }
}

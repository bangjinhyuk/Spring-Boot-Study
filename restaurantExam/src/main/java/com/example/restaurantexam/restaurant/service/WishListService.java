package com.example.restaurantexam.restaurant.service;

import com.example.restaurantexam.naver.dto.SearchImageReq;
import com.example.restaurantexam.naver.dto.SearchLocalReq;
import com.example.restaurantexam.naver.NaverClient;
import com.example.restaurantexam.restaurant.dto.WishListDto;
import com.example.restaurantexam.restaurant.entity.WishListEntity;
import com.example.restaurantexam.restaurant.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final WishListRepository wishListRepository;

    public WishListDto search(String query){
        //지역검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.SearchLocal(searchLocalReq);

        if (searchLocalRes.getTotal() >0){
            var item = searchLocalRes.getItems().stream().findFirst().get();

            var imageQuery = item.getTitle().replaceAll("<[^>]*>","");
            //이미지 검색
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);
            var searchImageRes =  naverClient.SearchImage(searchImageReq);

            if (searchImageRes.getTotal() > 0){
                var imageItem = searchImageRes.getItems().stream().findFirst().get();
                //결과 리턴
                var result = new WishListDto();
                result.setTitle(item.getTitle());
                result.setCategory(item.getCategory());
                result.setAddress(item.getAddress());
                result.setHomePageLink(item.getLink());
                result.setImageLink(imageItem.getLink());
                result.setRoadAddress(item.getRoadAddress());
                return result;
            }

        }
        return new WishListDto();

    }

    public WishListDto add(WishListDto wishListDto) {
        var entity = dtoToEntity(wishListDto);
        var saveEntity =  wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }

    private WishListEntity dtoToEntity(WishListDto wishListDto){
        var entity = new WishListEntity();
        entity.setIndex(wishListDto.getIndex());
        entity.setTitle(wishListDto.getTitle());
        entity.setAddress(wishListDto.getAddress());
        entity.setRoadAddress(wishListDto.getRoadAddress());
        entity.setCategory(wishListDto.getCategory());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setVisit(wishListDto.isVisit());
        entity.setLastVisitDate(wishListDto.getLastVisitDate());
        entity.setVisitCount(wishListDto.getVisitCount());
        return entity;

    }

    private WishListDto entityToDto(WishListEntity wishListEntity){
        var dto = new WishListDto();
        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setAddress(wishListEntity.getAddress());
        dto.setRoadAddress(wishListEntity.getRoadAddress());
        dto.setCategory(wishListEntity.getCategory());
        dto.setHomePageLink(wishListEntity.getHomePageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setVisit(wishListEntity.isVisit());
        dto.setLastVisitDate(wishListEntity.getLastVisitDate());
        dto.setVisitCount(wishListEntity.getVisitCount());
        return dto;

    }

    public List<WishListDto> findAll() {
        return wishListRepository.findAll()
                .stream()
                .map(it -> entityToDto(it))
                .collect(Collectors.toList());
    }

    public void delete(Integer index) {
        wishListRepository.deleteById(index);
    }

    public void addvisit(Integer index){
        var wishItem = wishListRepository.findById(index);
        if(wishItem.isPresent()){
            var item = wishItem.get();
            item.setVisit(true);
            item.setVisitCount(item.getVisitCount()+1);
            item.setLastVisitDate(LocalDateTime.now());
        }
    }
}

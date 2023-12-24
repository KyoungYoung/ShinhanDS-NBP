package com.delivery.domain.store.dto;

import com.delivery.domain.owner.entity.OwnerEntity;
import com.delivery.domain.store.entity.StoreEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StoreDto {
    private Long id;
    //@JsonProperty("owner_id")
    private Long ownerId;
    private String name;
    private String description;
    private String category;
    private int rating;
    private String file;


    public static StoreDto toDummyStore(StoreEntity storeEntity, OwnerEntity ownerEntity){
        return new StoreDto(
                storeEntity.getId(),
                ownerEntity.getId(),
                storeEntity.getName(),
                storeEntity.getDescription(),
                storeEntity.getCategory(),
                storeEntity.getRating(),
                storeEntity.getFile()
        );
    }

    public StoreEntity toEntity(OwnerEntity ownerEntity) {
        return new StoreEntity(
                this.id,
                ownerEntity,
                this.name,
                this.description,
                this.category,
                this.rating,
                this.file
        );
    }
}

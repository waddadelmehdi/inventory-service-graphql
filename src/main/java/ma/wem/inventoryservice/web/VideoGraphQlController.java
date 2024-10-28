package ma.wem.inventoryservice.web;

import ma.wem.inventoryservice.dao.entities.Creator;
import ma.wem.inventoryservice.dao.repository.CreatorRepository;
import ma.wem.inventoryservice.dao.repository.VideoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class VideoGraphQlController {
    private CreatorRepository creatorRepository;
    private VideoRepository videoRepository;

    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.creatorRepository = creatorRepository; this.videoRepository = videoRepository;
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id){
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }


}

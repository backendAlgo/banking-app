package uz.najottalim.bankingapp.mapper;

import org.springframework.stereotype.Component;
import uz.najottalim.bankingapp.dto.NewsDTO;
import uz.najottalim.bankingapp.models.News;

@Component
public class NewsMapper {
    public News toEntity(NewsDTO newsDTO){
        if(newsDTO == null) return null;
        return new News();
    }

    public NewsDTO toDto(News news){
        if(news == null) return null;
        return new NewsDTO();
    }
}

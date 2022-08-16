package com.alkemy.repository.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alkemy.entity.GenreEntity;
import com.alkemy.entity.MovieEntity;
import com.alkemy.modelDTO.MovieFiltersDTO;

@Component
public class MovieSpecification {

	public Specification<MovieEntity> getByFilters(MovieFiltersDTO filtersDTO) {
		
		return (root, query, criteriaBuilder) -> {
			
			List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.hasLength(filtersDTO.getTitle())) {
				predicates.add(
						criteriaBuilder.like(
								criteriaBuilder.lower(root.get("title")),
								"%" + filtersDTO.getTitle().toLowerCase() + "%"
						)
				);
			}
			
			if (!CollectionUtils.isEmpty(filtersDTO.getGenres())) {
				Join<GenreEntity, MovieEntity> join = root.join("associatedGenres", JoinType.INNER);
				Expression<String> genresId = join.get("id");
				predicates.add(genresId.in(filtersDTO.getGenres()));
			}
			
			//Remove duplicates
			query.distinct(true);
			
			String orderByField = "dateCreation";
			query.orderBy(
					filtersDTO.isASC() ?
							criteriaBuilder.asc(root.<LocalDate>get(orderByField)) :
							criteriaBuilder.desc(root.<LocalDate>get(orderByField))
			);
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}

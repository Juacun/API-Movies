package com.alkemy.repository.specification;

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

import com.alkemy.entity.CharacterEntity;
import com.alkemy.entity.MovieEntity;
import com.alkemy.modelDTO.CharacterFiltersDTO;

@Component
public class CharacterSpecification {

	public Specification<CharacterEntity> getByFilters(CharacterFiltersDTO filtersDTO) {
		
		return (root, query, criteriaBuilder) -> {
			
			List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.hasLength(filtersDTO.getName())) {
				predicates.add(
						criteriaBuilder.like(
								criteriaBuilder.lower(root.get("name")),
								"%" + filtersDTO.getName().toLowerCase() + "%"
						)
				);
			}
			
			if (StringUtils.hasLength(filtersDTO.getAge())) {
				int age = Integer.valueOf(filtersDTO.getAge());
				
				predicates.add(
						criteriaBuilder.equal(root.get("age"), age)
				);
			}
			
			if (StringUtils.hasLength(filtersDTO.getWeight())) {
				float weight = Float.valueOf(filtersDTO.getWeight());
				
				predicates.add(
						criteriaBuilder.equal(root.get("weight"), weight)
				);
			}
			
			if (!CollectionUtils.isEmpty(filtersDTO.getMovies())) {
				Join<MovieEntity, CharacterEntity> join = root.join("associatedMovies", JoinType.INNER);
				Expression<String> moviesId = join.get("id");
				predicates.add(moviesId.in(filtersDTO.getMovies()));
			}
			
			//Remove duplicates
			query.distinct(true);
			
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}

package com.microsvs.product.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, nullable = false)
	private String name; // e.g. "Electronics", "Mobiles", "Tablets"

	// Parent category (for sub-categories)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Category parent;

	// Child categories
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private Set<Category> subCategories;
}

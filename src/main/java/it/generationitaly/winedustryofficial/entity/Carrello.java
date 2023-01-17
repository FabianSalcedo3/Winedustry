package it.generationitaly.winedustryofficial.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrello")
public class Carrello {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(mappedBy = "carrello", fetch = FetchType.EAGER)
	private List<CarrelloItem> carrelloItems = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CarrelloItem> getCarrelloItems() {
		return carrelloItems;
	}

	public void setCarrelloItems(List<CarrelloItem> carrelloItems) {
		this.carrelloItems = carrelloItems;
	}

	@Override
	public String toString() {
		return "Carrello{" + "id=" + id + '}';
	}
}

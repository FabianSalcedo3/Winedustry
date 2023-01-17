package entities.carrello;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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

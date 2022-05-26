package com.marwa.voitures;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.marwa.voitures.entities.Marque;
import com.marwa.voitures.entities.Modele;
import com.marwa.voitures.entities.Voiture;
import com.marwa.voitures.repos.VoitureRepository;

@SpringBootTest
class VoituresApplicationTests {

	@Autowired
	private VoitureRepository voitureRepository;

	@Test
	public void testCreateVoiture() {
		Voiture voit = new Voiture(1500.500, "coupé", new Date(), null);
		voitureRepository.save(voit);
	}

	@Test
	public void testFindVoiture() {
		Voiture v = voitureRepository.findById(1L).get();

		System.out.println(v);
	}

	@Test
	public void testUpdateVoiture() {
		Voiture v = voitureRepository.findById(1L).get();
		v.setPrixVoiture(1000.0);
		voitureRepository.save(v);
	}

	@Test
	public void testDeleteVoiture() {
		voitureRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousVoitures() {
		List<Voiture> voits = voitureRepository.findAll();
		for (Voiture v : voits) {
			System.out.println(v);
		}

	}

	@Test
	public void testFindVoitureByNom() {
		List<Voiture> voits = voitureRepository.findByTypeVoiture("BMW");

		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void testFindVoitureByNomContains() {
		List<Voiture> voits = voitureRepository.findByTypeVoiture("M");

		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Voiture> voits = voitureRepository.findByTypeVoiturePrixVoiture("BMW", 1000.0);
		for (Voiture v : voits) {
			System.out.println(v);
		}

	}

	@Test
	public void testfindByModele() {
		Modele mod = new Modele();
		mod.setIdMod(1L);
		List<Voiture> voits = voitureRepository.findByModele(mod);
		for (Voiture v : voits) {
			System.out.println(v);
		}

	}

	@Test
	public void findByModeleIdMod() {
		List<Voiture> voits = voitureRepository.findByModeleIdMod(1L);
		for (Voiture v : voits) {
			System.out.println(v);
		}

	}

	@Test
	public void testTrierProduitsNomsPrixVoiture() {
		List<Voiture> voits = voitureRepository.trierVoituresTypeVoituresPrixVoiture();
		for (Voiture v : voits) {
			System.out.println(v);
		}

	}

	@Test
	public void testfindByMarque() {
		Marque mar = new Marque();
		//mar.setIdMar(1L);
		List<Voiture> voits = voitureRepository.findByMarque(mar);
		for (Voiture v : voits) {
			System.out.println(v);
		}
	}

	@Test
	public void findByMarqueIdMar() {
		List<Voiture> prods = voitureRepository.findByMarqueIdMar(1L);
		for (Voiture v : prods) {
			System.out.println(v);
		}
	}

}

package com.example.ac2;

import com.example.ac2.models.Categoria;
import com.example.ac2.models.Produto;
import com.example.ac2.repositories.CategoriaRepository;
import com.example.ac2.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Ac1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
								  @Autowired CategoriaRepository categoriaRepository) {
		return args -> {

			System.out.println(" * CATEGORIAS * ");
			Categoria c1 = new Categoria("Equipamentos de informática");
			Categoria c2 = new Categoria("Materiais de escritório");
			Categoria c3 = new Categoria("Brinquedos");
			Categoria c4 = new Categoria("Itens de limpeza");

			System.out.println("INSERINDO CATEGORIA:");
			System.out.println(categoriaRepository.save(c1));
			System.out.println(categoriaRepository.save(c2));
			System.out.println(categoriaRepository.save(c3));
			System.out.println("-".repeat(60));

			System.out.println("OBTENDO TODAS AS CATEGORIAS:");
			System.out.println(categoriaRepository.findAll());
			System.out.println("-".repeat(60));

			System.out.println("EDITANDO CATEGORIA:");
			c4 = categoriaRepository.findById(2L).orElseThrow();
			c4.setNome("Roupas e acessórios");
			System.out.println(categoriaRepository.save(c2));
			System.out.println("-".repeat(60));

			System.out.println("OBTENDO CATEGORIA PELO NOME:");
			System.out.println(categoriaRepository.findByNomeLike("%inf%"));
			System.out.println("-".repeat(60));

			System.out.println("EXCLUINDO CATEGORIA:");
			categoriaRepository.findById(2L).orElseThrow();
			System.out.println(c4 + " excluído com sucesso!" );
			categoriaRepository.delete(c4);
			System.out.println(categoriaRepository.findAll());

			c1 = categoriaRepository.findById(1L).orElseThrow();

			List<Produto> produtos = new ArrayList<>();
			Produto p1 = new Produto("Notebook", 4000.0, c1);
			produtos.add(p1);
			Produto p2 = new Produto("Playstation 5", 5000.0, c1);
			produtos.add(p2);
			Produto p3 = new Produto("Mouse", 200.0, c1);
			produtos.add(p3);
			c1.setProdutos(produtos);
			categoriaRepository.save(c1);

			System.out.println();
			System.out.println(" * PRODUTO * ");

			System.out.println("INSERINDO PRODUTO:");
			System.out.println(produtoRepository.save(p1));
			System.out.println(produtoRepository.save(p2));
			System.out.println(produtoRepository.save(p3));
			System.out.println("-".repeat(60));

			System.out.println(produtoRepository.findAll());

			System.out.println("EDITANDO PRODUTO:");
			p2 = produtoRepository.findById(2L).orElseThrow();
			p2.setPreco(6000.0);
			produtoRepository.save(p2);
			System.out.println(p2);
			System.out.println("-".repeat(60));

			System.out.println("OBTENDO PRODUTO COM VALOR MAIOR QUE:");
			System.out.println(produtoRepository.findByPrecoGreaterThan(4000.0));
			System.out.println("-".repeat(60));

			System.out.println("OBTENDO PRODUTO COM VALOR MENOR OU IGUAL QUE:");
			System.out.println(produtoRepository.findByPrecoIsLessThanEqual(4000.0));
			System.out.println("-".repeat(60));

			System.out.println("OBTENDO PRODUTO PELO NOME:");
			System.out.println(produtoRepository.findByNomeLike("%M%"));
			System.out.println("-".repeat(60));

			System.out.println("EXCLUINDO PRODUTO:");
			p2 = produtoRepository.findById(2L).orElseThrow();
			System.out.println("Excluindo " + p2);
			produtoRepository.delete(p2);
			c1.getProdutos().remove(1);
			categoriaRepository.save(c1);
			System.out.println(produtoRepository.findAll());
			System.out.println("-".repeat(60));

			System.out.println("CHAMANDO A CATEGORIA COM SEUS PRODUTOS:");
			System.out.println(categoriaRepository.findCategoriaCursoFetchCursos(1L));
		};
	}
}

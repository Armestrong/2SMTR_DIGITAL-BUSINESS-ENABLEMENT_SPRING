package br.com.fiap.exemploh2.controller;

import br.com.fiap.exemploh2.entity.Produto;
import br.com.fiap.exemploh2.view.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "form";
    }

    @PostMapping("/produto/cadastrar")
    public String processarForm(Produto produto) {
        repository.save(produto);

        System.out.print(produto.getNome() + " " + produto.getPreco());
        return "sucesso";
    }

    @GetMapping("/busca")
    public String buscar() {
        return "busca";
    }

    @PostMapping("/busca")
    public String processarForm(int codigo, Model model) {
        Optional<Produto> produto = repository.findById(codigo);
        model.addAttribute("prod", produto);
        return "resultado";
    }


}

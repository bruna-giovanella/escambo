package com.escambo.Controller;

import com.escambo.Dto.MercadoriaDto;
import com.escambo.Entity.Mercadoria;
import com.escambo.Service.MercadoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mercadorias")
public class MercadoriaController {

    private final MercadoriaService mercadoriaService;

    public MercadoriaController(MercadoriaService mercadoriaService) {
        this.mercadoriaService = mercadoriaService;
    }

    @GetMapping
    public String listarTodas(Model model) {
        List<Mercadoria> mercadorias = mercadoriaService.listarTodasAsMercadorias();
        model.addAttribute("mercadorias", mercadorias);
        return "lista";
    }

    @GetMapping("/visualizar/{mercadoriaId}")
    public String visualizar(@PathVariable Long mercadoriaId, Model model) {
        Mercadoria mercadoria = mercadoriaService.visualizarMercadoria(mercadoriaId);
        model.addAttribute("mercadoria", mercadoria);
        return "visualizar";
    }

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("mercadoriaDto", new MercadoriaDto("", "", ""));
        model.addAttribute("action", "salvar");
        return "form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute MercadoriaDto mercadoriaDto) {
        mercadoriaService.salvarMercadoria(mercadoriaDto);
        return "redirect:/mercadorias";
    }

    @GetMapping("/editar/{mercadoriaId}")
    public String mostrarFormularioEdicao(@PathVariable Long mercadoriaId, Model model) {
        Mercadoria mercadoria = mercadoriaService.visualizarMercadoria(mercadoriaId);

        MercadoriaDto dto = new MercadoriaDto(
                mercadoria.getNome(),
                mercadoria.getDescricao(),
                mercadoria.getImagemUrl()
        );

        model.addAttribute("mercadoriaDto", dto);
        model.addAttribute("mercadoriaId", mercadoriaId);
        model.addAttribute("action", "atualizar");
        return "form";
    }

    @PostMapping("/atualizar/{mercadoriaId}")
    public String atualizar(@PathVariable Long mercadoriaId, @ModelAttribute MercadoriaDto mercadoriaDto) {
        mercadoriaService.atualizarMercadoria(mercadoriaId, mercadoriaDto);
        return "redirect:/mercadorias";
    }

    @GetMapping("/deletar/{mercadoriaId}")
    public String deletar(@PathVariable Long mercadoriaId) {
        mercadoriaService.deletarMercadoria(mercadoriaId);
        return "redirect:/mercadorias";
    }
}

package com.hajba.restTry.rest.controller.resume;

import com.hajba.restTry.model.resume.FullResume;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("resume") // изначальная приставка для обращения к данному классу
public class FullResumeController {

    private FullResume resume = new FullResume();

    private List<FullResume> resumes = new ArrayList<>();

    public FullResumeController() {
        resume.setAboutYourself("setAboutYourself");
        resume.setAditionalInfo("setAditionalInfo");
        resume.setCourse(4);
        resume.setName("Vova");
        resumes.add(resume);
        resumes.add(resume);
        resumes.add(resume);
        resumes.add(resume);
    }

    @GetMapping
    public List<FullResume> getResumes(){
        return resumes;
    }

    @GetMapping("/{id}")
    public FullResume getResumeById(@PathVariable int id){
        return resumes.get(id);
    }

    @PostMapping
    public FullResume createResume(@RequestBody FullResume resume){
        resumes.add(resume);
        return resume;
    }
    @GetMapping("/create/static")
    public FullResume createStaticResume(){
        resumes.add(this.resume);
        return resume;
    }

    @PutMapping("/{id}")
    public FullResume updateResume(@RequestBody FullResume resume, @PathVariable int id){
        resumes.set(id,resume);
        return resume;
    }

    /*@PutMapping("{id}")
    public FullResume getResumeById(@RequestBody FullResume resume, @PathVariable int id){
        resumes.set(id,resume);
        return resume;
    }*/

    @DeleteMapping("/{id}")
    public void deleteResume(@PathVariable int id){
        resumes.remove(id);
    }
}

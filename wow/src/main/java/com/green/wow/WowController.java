package com.green.wow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wow")
public class WowController {
    private final WowService service;

    @Autowired // 자동으로 주소값을 주입해준다.
    public WowController(WowService service) {
        this.service = service;
    }

    @PostMapping
    public int WowPost(@RequestBody WowEntity entity) {
        System.out.println(entity);
        return service.insWow(entity);
    }

    @GetMapping
    public List<WowEntity> WowGet() {
        return service.selWow();
    }
    @GetMapping("/{no}")
    public WowEntity selWowById(@PathVariable int no) {
        WowEntity entity= new WowEntity();
        entity.setNo(no);
        System.out.println(entity);
        return service.selWowById(entity);
    }

    @PutMapping
    public int WowPut(@RequestBody WowEntity entity) {
        System.out.println(entity);
        return service.updWow(entity);
    }

    @DeleteMapping("/{no}")
    public int WowDelete(@PathVariable int no) {// restful 화 한것임
        WowEntity entity= new WowEntity();
        entity.setNo(no);
        System.out.println(entity);
        return service.delWow(entity);
    }

}

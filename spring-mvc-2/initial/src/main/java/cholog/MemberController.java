package cholog;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MemberController {

    private final List<Member> members = new ArrayList<>();
    private final AtomicLong index = new AtomicLong(1);

    @PostMapping("/members")
    public ResponseEntity<Void> create(@RequestBody Member member) {
        // TODO: member 정보를 받아서 생성한다. -> 어노테이션 @RequestBody 사용
        Member newMember = Member.toEntity(null, index.getAndIncrement());
        members.add(newMember);
        return ResponseEntity.created(URI.create("/members/" + newMember.getId())).build();
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> read() {
        return ResponseEntity.ok().body(members);
        // TODO: 저장된 모든 member 정보를 반환한다. ResponseEntity
        return null;
    }

    @PutMapping("/members/{id}")
    public ResponseEntity<Void> update(@RequestBody Member newMember, @PathVariable Long id) {
        // TODO: member의 수정 정보와 url 상의 id 정보를 받아 member 정보를 수정한다.
        Member member = members.stream()
            .filter(it -> Objects.equals(it.getId(), id))
            .findFirst()
            .orElseThrow(RuntimeException::new);

        member.update(newMember);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> delete() {
        // TODO: url 상의 id 정보를 받아 member를 삭제한다.
        Member member = members.stream()
            .filter(it -> Objects.equals(it.getId(), null))
            .findFirst()
            .orElseThrow(RuntimeException::new);

        members.remove(member);

        return null;
    }
}

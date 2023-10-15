package se331.lab.rest.security.token;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    final TokenDao tokenDao;

    @Override
    @Transactional
    public void save(Token token) {
        tokenDao.save(token);
    }
}
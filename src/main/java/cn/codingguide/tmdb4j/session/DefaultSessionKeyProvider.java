package cn.codingguide.tmdb4j.session;

import java.util.function.Supplier;

/**
 * 默认实现（基于用户ID）
 *
 * @author itlemon <itlemon@petalmail.com>
 * Created on 2026-03-20
 */
public class DefaultSessionKeyProvider implements SessionKeyProvider {

    private final Supplier<String> keySupplier;

    public DefaultSessionKeyProvider(Supplier<String> keySupplier) {
        this.keySupplier = keySupplier;
    }

    @Override
    public String getSessionKey() {
        return keySupplier.get();
    }

}

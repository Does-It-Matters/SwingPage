package org.example.core.registry;

import org.example.core.intent.IIntent;
import org.example.core.page.presentation.AbstractIPage;

public interface IPageRegistry {

    void register(IIntent intent, AbstractIPage page);

    AbstractIPage get(IIntent intent);
}

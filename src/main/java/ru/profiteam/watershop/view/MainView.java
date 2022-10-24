package ru.profiteam.watershop.view;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.repository.UserRepository;

@Route
public class MainView extends VerticalLayout {
    private final UserRepository userRepository;
    private Grid<User> grid = new Grid<>(User.class);

    @Autowired
    public MainView(UserRepository userRepository) {
        this.userRepository = userRepository;

        add(grid);
        grid.setItems(userRepository.findAll());
    }
}

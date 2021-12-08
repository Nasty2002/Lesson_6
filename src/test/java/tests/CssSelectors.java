package tests;

import org.openqa.selenium.By;

public class CssSelectors {

    private void cssSelectors(){
        By classSelector = By.cssSelector(".radio"); // поиск по классу radio
        By classSelector1 = By.className("radio"); // поиск по классу radio

        By idSelector = By.cssSelector("#suite_mode_single"); // поиск по id
        By idSelector1 = By.id("#suite_mode_single"); // поиск по id

        By tagSelector = By.cssSelector("Label"); // поиск по tag
        By tagSelector1 = By.tagName("Label"); // поиск по tag

        By tagAttributeSelector = By.cssSelector("label[for='name']"); // поиск по tag и атрибуту с значением
        By tagAttributeSelector1 = By.cssSelector("label[for]"); // поиск по tag и присутствием атрибуту

        By multipleClassesSelector = By.cssSelector(".column.overflow-content"); // поиск по двум классам в элементе

        By simpleHierarchicalSelector = By.cssSelector(".table.content-inner"); // поиск простого дочернего элемента

        By fullHierarchicalSelector = By.cssSelector("body.table.content-inner"); // поиск трехуровневой иерархии для поиска дочернего элемента

        By searchLikeContainsSelector = By.cssSelector("form[action*='admin']"); // поиск c вхождением в значении атрибута
        By searchByWordSelector = By.cssSelector("form[action~='admin']"); // поиск с входжением в значении атрибута

        By valueStartsFromSelector = By.cssSelector("a[href^='https://']"); // поиск элемента с аттрибутом значение которого начинается с

        By valueEndWithSelector = By.cssSelector("a[href$='@gmail.com']"); // поиск элемента с аттрибутом значение которого заканчивается на


    }
}

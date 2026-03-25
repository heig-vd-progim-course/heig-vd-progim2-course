"""
Tri à bulles (Bubble Sort) - Animation

Ce fichier contient une animation du tri à bulles utilisant Manim Community.
L'animation montre le parcours de l'algorithme avec les comparaisons et les échanges.
"""

from manim import *


class BubbleSortAnimation(Scene):
    """Animation du tri à bulles avec un tableau de nombres."""

    def construct(self):
        # Configuration
        array_values = [5, 2, 8, 1, 9, 3]
        colors = {
            "default": BLUE,
            "comparing": YELLOW,
            "swapping": RED,
            "sorted": GREEN,
        }

        # Titre
        title = Text("Tri à bulles (Bubble Sort)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))
        self.wait(1)

        # Créer les rectangles représentant les éléments
        rectangles = VGroup()
        labels = VGroup()

        for i, value in enumerate(array_values):
            # Rectangle
            rect = Rectangle(
                width=1.0,
                height=0.6,
                fill_color=colors["default"],
                fill_opacity=0.7,
                stroke_color=WHITE,
            )

            # Valeur
            label = Text(str(value), font_size=32, color=WHITE)
            label.move_to(rect.get_center())

            # Positionner
            rect.shift(RIGHT * i * 1.2)
            label.shift(RIGHT * i * 1.2)

            rectangles.add(rect)
            labels.add(label)

        # Grouper et centrer
        array_group = VGroup(rectangles, labels)
        array_group.move_to(ORIGIN)

        # Afficher le tableau
        self.play(
            *[GrowFromCenter(rect) for rect in rectangles],
            *[Write(label) for label in labels],
        )
        self.wait(1)

        # Algorithme de tri à bulles
        n = len(array_values)

        for i in range(n):
            for j in range(0, n - i - 1):
                # Mettre en surbrillance les éléments comparés
                self.play(
                    rectangles[j].animate.set_fill(colors["comparing"]),
                    rectangles[j + 1].animate.set_fill(colors["comparing"]),
                    run_time=0.3,
                )
                self.wait(0.2)

                # Comparer et échanger si nécessaire
                if array_values[j] > array_values[j + 1]:
                    # Indiquer l'échange
                    self.play(
                        rectangles[j].animate.set_fill(colors["swapping"]),
                        rectangles[j + 1].animate.set_fill(colors["swapping"]),
                        run_time=0.3,
                    )

                    # Échanger les valeurs dans le tableau
                    array_values[j], array_values[j + 1] = (
                        array_values[j + 1],
                        array_values[j],
                    )

                    # Animer l'échange
                    self.play(
                        rectangles[j].animate.shift(RIGHT * 1.2),
                        rectangles[j + 1].animate.shift(LEFT * 1.2),
                        labels[j].animate.shift(RIGHT * 1.2),
                        labels[j + 1].animate.shift(LEFT * 1.2),
                        run_time=1,
                    )

                    # Échanger les références
                    rectangles[j], rectangles[j + 1] = (
                        rectangles[j + 1],
                        rectangles[j],
                    )
                    labels[j], labels[j + 1] = labels[j + 1], labels[j]

                    self.wait(0.2)

                # Remettre à la couleur par défaut
                self.play(
                    rectangles[j].animate.set_fill(colors["default"]),
                    rectangles[j + 1].animate.set_fill(colors["default"]),
                    run_time=0.2,
                )

            # Marquer le dernier élément comme trié
            self.play(
                rectangles[n - i - 1].animate.set_fill(colors["sorted"]), run_time=0.3
            )
            self.wait(0.3)

        # Marquer tous les éléments restants comme triés
        for j in range(n - i - 1):
            self.play(rectangles[j].animate.set_fill(colors["sorted"]), run_time=0.2)

        # Message final
        sorted_text = Text("Tableau trié !", font_size=32, color=GREEN)
        sorted_text.next_to(array_group, DOWN, buff=1)
        self.play(Write(sorted_text))
        self.wait(2)


class BubbleSortWithCards(Scene):
    """Animation du tri à bulles avec des cartes à jouer."""

    def construct(self):
        # Configuration des cartes
        card_values = [5, 2, 8, 3, 9, 4]
        card_suits = ["spades", "spades", "spades", "spades", "spades", "spades"]
        
        # Chemin vers les images
        images_path = "../../images/"
        
        # Couleurs pour les états
        colors = {
            "comparing": YELLOW,
            "sorted": GREEN,
        }
        
        # Titre
        title = Text("Tri à bulles (Bubble Sort)", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))
        self.wait(1)

        # Créer les cartes avec des bordures
        cards = VGroup()
        borders = VGroup()
        
        for i, (value, suit) in enumerate(zip(card_values, card_suits)):
            # Charger l'image SVG de la carte
            card_name = f"{value}_of_{suit}.svg"
            card = SVGMobject(images_path + card_name)
            card.scale(1)
            card.shift(RIGHT * i * 1.8)
            
            # Créer une bordure invisible par défaut
            border = Rectangle(
                width=card.width + 0.2,
                height=card.height + 0.2,
                stroke_width=6,
                stroke_color=WHITE,
                stroke_opacity=0,
                fill_opacity=0
            )
            border.move_to(card.get_center())
            
            cards.add(card)
            borders.add(border)

        # Grouper et centrer
        card_group = VGroup(cards, borders)
        card_group.move_to(ORIGIN)

        # Afficher les cartes
        self.play(*[FadeIn(card) for card in cards])
        self.add(*borders)  # Ajouter les bordures (invisibles)
        self.wait(1)

        # Algorithme de tri à bulles
        n = len(card_values)

        for i in range(n):
            for j in range(0, n - i - 1):
                # Mettre en surbrillance les cartes comparées avec _selected.svg
                selected_card_j = SVGMobject(
                    images_path + f"{card_values[j]}_of_{card_suits[j]}_selected.svg"
                )
                selected_card_j.scale(1)
                selected_card_j.move_to(cards[j].get_center())

                selected_card_j1 = SVGMobject(
                    images_path + f"{card_values[j + 1]}_of_{card_suits[j + 1]}_selected.svg"
                )
                selected_card_j1.scale(1)
                selected_card_j1.move_to(cards[j + 1].get_center())

                self.play(
                    Transform(cards[j], selected_card_j),
                    Transform(cards[j + 1], selected_card_j1),
                    run_time=0.3,
                )
                self.wait(0.2)

                # Comparer et échanger si nécessaire
                if card_values[j] > card_values[j + 1]:
                    # Échanger les valeurs
                    card_values[j], card_values[j + 1] = (
                        card_values[j + 1],
                        card_values[j],
                    )
                    card_suits[j], card_suits[j + 1] = (
                        card_suits[j + 1],
                        card_suits[j],
                    )

                    # Animer l'échange
                    self.play(
                        cards[j].animate.shift(RIGHT * 1.8),
                        cards[j + 1].animate.shift(LEFT * 1.8),
                        borders[j].animate.shift(RIGHT * 1.8),
                        borders[j + 1].animate.shift(LEFT * 1.8),
                        run_time=0.5,
                    )

                    # Échanger les références
                    cards[j], cards[j + 1] = cards[j + 1], cards[j]
                    borders[j], borders[j + 1] = borders[j + 1], borders[j]
                    self.wait(0.2)

                # Remettre à l'état par défaut avec les cartes normales
                default_card_j = SVGMobject(
                    images_path + f"{card_values[j]}_of_{card_suits[j]}.svg"
                )
                default_card_j.scale(1)
                default_card_j.move_to(cards[j].get_center())

                default_card_j1 = SVGMobject(
                    images_path + f"{card_values[j + 1]}_of_{card_suits[j + 1]}.svg"
                )
                default_card_j1.scale(1)
                default_card_j1.move_to(cards[j + 1].get_center())

                self.play(
                    Transform(cards[j], default_card_j),
                    Transform(cards[j + 1], default_card_j1),
                    run_time=0.2,
                )

            # Marquer le dernier élément comme trié avec la carte _sorted.svg
            sorted_card = SVGMobject(
                images_path + f"{card_values[n - i - 1]}_of_{card_suits[n - i - 1]}_sorted.svg"
            )
            sorted_card.scale(1)
            sorted_card.move_to(cards[n - i - 1].get_center())
            
            self.play(
                Transform(cards[n - i - 1], sorted_card),
                run_time=0.3
            )
            self.wait(0.3)

        # Marquer tous les éléments restants comme triés
        for j in range(n - i - 1):
            sorted_card = SVGMobject(
                images_path + f"{card_values[j]}_of_{card_suits[j]}_sorted.svg"
            )
            sorted_card.scale(1)
            sorted_card.move_to(cards[j].get_center())
            
            self.play(
                Transform(cards[j], sorted_card),
                run_time=0.2
            )

        # Message final
        sorted_text = Text("Cartes triées !", font_size=32, color=GREEN)
        sorted_text.next_to(card_group, DOWN, buff=1)
        self.play(Write(sorted_text))
        self.wait(2)


class BubbleSortSimple(Scene):
    """Version simplifiée de l'animation pour une génération rapide."""

    def construct(self):
        # Tableau initial
        array = [64, 34, 25, 12, 22]
        
        # Titre
        title = Text("Tri à bulles", font_size=40)
        title.to_edge(UP)
        self.play(Write(title))
        
        # Créer les barres
        bars = self.create_bars(array)
        self.play(Create(bars))
        self.wait(1)
        
        # Effectuer le tri
        n = len(array)
        for i in range(n):
            for j in range(0, n - i - 1):
                if array[j] > array[j + 1]:
                    array[j], array[j + 1] = array[j + 1], array[j]
                    new_bars = self.create_bars(array)
                    self.play(Transform(bars, new_bars), run_time=0.3)
        
        self.wait(2)
    
    def create_bars(self, values):
        """Crée des barres représentant les valeurs."""
        bars = VGroup()
        max_height = 3
        max_value = max(values)
        
        for i, value in enumerate(values):
            height = (value / max_value) * max_height
            bar = Rectangle(
                width=1,
                height=height,
                fill_color=BLUE,
                fill_opacity=1,
                stroke_color=WHITE,
            )
            bar.shift(RIGHT * (i - len(values) / 2) * 1.2)
            bar.align_to(ORIGIN, DOWN)
            
            # Ajouter la valeur en texte
            label = Text(str(value), font_size=20)
            label.next_to(bar, UP, buff=0.1)
            
            bar_group = VGroup(bar, label)
            bars.add(bar_group)
        
        return bars

import { ScrollView, Text, View, FlatList, StyleSheet } from "react-native";
import ExerciseItem from "./ExerciseItem";
import Header from "./Header";

export default function Exercises({ navigation }) {
  const renderItem = (item) => {
    return (
      <ExerciseItem
        iconName={item.item.iconName}
        name={item.item.name}
        description={item.item.description}
      ></ExerciseItem>
    );
  };

  const keyExtractor = (item) => {
    item.id;
  };

  return (
    <View>
      <Header />
      <FlatList
        style={styles.exercisesFlatListContainer}
        data={exercisesData}
        renderItem={renderItem}
        keyExtractor={keyExtractor}
      ></FlatList>
    </View>
  );
}

const styles = StyleSheet.create({
  exercisesFlatListContainer: { width: "100%", height: "89%" },
});

const exercisesData = [
  {
    id: 0,
    iconName: "body",
    name: "Общеразвивающие упражнения (начальный уровень)",
    description:
      "Комплекс упражнений, развивающих все части человеческого тела",
  },
  {
    id: 1,
    iconName: "body",
    name: "Общеразвивающие упражнения (продвинутый уровень)",
    description:
      "Комплекс упражнений, развивающих все части человеческого тела",
  },
  {
    id: 2,
    iconName: "body",
    name: "Общеразвивающие упражнения (профессиональный уровень)",
    description:
      "Комплекс упражнений, развивающих все части человеческого тела",
  },
  {
    id: 3,
    iconName: "barbell",
    name: "Упражнения на грудь (начальный уровень)",
    description:
      "Комплекс упражнений, развивающих грудный и сопряженные с ними мышцы",
  },
  {
    id: 4,
    iconName: "barbell",
    name: "Упражнения на грудь (продвинутый уровень)",
    description:
      "Комплекс упражнений, развивающих грудный и сопряженные с ними мышцы",
  },
  {
    id: 5,
    iconName: "barbell",
    name: "Упражнения на грудь (профессиональный уровень)",
    description:
      "Комплекс упражнений, развивающих грудный и сопряженные с ними мышцы",
  },
  {
    id: 6,
    iconName: "basketball",
    name: "Упражнения с мячом",
    description: "Комплекс упражнений, проводимых с мячом",
  },
];

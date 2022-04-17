import { View, StyleSheet, Text, ScrollView } from "react-native";
import { Ionicons } from "@expo/vector-icons";
import { COLORS } from "./colors";

export default function ExerciseItem(props) {
  return (
    <View style={styles.exerciseItemContainer}>
      <Ionicons name={props.iconName} style={styles.exerciseItemIcon} />
      <ScrollView
        style={styles.exerciseItemTextContainer}
        showsVerticalScrollIndicator={false}
        justifyContent="center"
      >
        <Text style={styles.exerciseItemNameText}>{props.name}</Text>
        <Text style={styles.exerciseItemPlainText}>{props.description}</Text>
      </ScrollView>
      <Ionicons name="arrow-forward" style={styles.exerciseItemArrowIcon} />
    </View>
  );
}
const styles = StyleSheet.create({
  exerciseItemContainer: {
    width: "100%",
    height: 200,
    borderBottomColor: COLORS.black,
    borderBottomWidth: 0.5,
    padding: "2%",
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
  },
  exerciseItemIcon: { fontSize: 100 },
  exerciseItemTextContainer: {
    width: "60%",
    height: "94%",
    padding: "1%",
  },
  exerciseItemArrowIcon: { fontSize: 30, color: COLORS.primary },
  exerciseItemNameText: {
    textAlign: "justify",
    fontSize: 20,
    fontWeight: "bold",
  },
  exerciseItemPlainText: {
    textAlign: "justify",
    fontSize: 15,
  },
});

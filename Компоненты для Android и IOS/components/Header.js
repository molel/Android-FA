import { Text, View, StyleSheet, TextInput } from "react-native";
import { COLORS } from "./colors";
import { AntDesign } from "@expo/vector-icons";

export default function Header() {
  return (
    <View>
      <View style={styles.topContainer}></View>
      <View style={styles.mainContainer}>
        <AntDesign name="search1" style={styles.searchIcon} />
        <TextInput
          placeholder="Название упражнения"
          style={styles.textInput}
        ></TextInput>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  topContainer: {
    width: "100%",
    height: 40,
    backgroundColor: COLORS.primaryDark,
  },
  mainContainer: {
    width: "100%",
    height: 50,
    backgroundColor: COLORS.primary,
    padding: 5,
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-around",
    alignItems: "center",
  },
  searchIcon: { fontSize: 30 },
  textInput: {
    width: "80%",
    borderColor: COLORS.primaryDark,
    borderStyle: "solid",
    borderWidth: 2,
    borderRadius: 10,
    backgroundColor: COLORS.white,
    paddingHorizontal: 10,
    paddingVertical: 5,
    fontSize: 25,
  },
});

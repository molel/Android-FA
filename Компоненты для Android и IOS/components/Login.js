import {
  View,
  Text,
  StyleSheet,
  TextInput,
  TouchableOpacity,
  Image,
} from "react-native";
import { Colors } from "react-native/Libraries/NewAppScreen";
import { COLORS } from "./colors";

export default function Form() {
  return (
    <View style={styles.screenContainer}>
      <Image
        source={require("../assets/images/login.png")}
        style={styles.image}
      />
      <View style={styles.headerTextContainer}>
        <Text style={styles.headerText}>Авторизация</Text>
      </View>
      <View style={styles.plainTextContainer}>
        <Text style={styles.plainText}>
          Введите логин и пароль, который создавали ранее при регистрации
        </Text>
      </View>
      <View style={styles.textInputContainer}>
        <TextInput style={styles.textInput} placeholder={"Логин"}></TextInput>
      </View>
      <View style={styles.textInputContainer}>
        <TextInput
          style={styles.textInput}
          secureTextEntry={true}
          placeholder={"Пароль"}
        ></TextInput>
      </View>
      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.button}>
          <Text style={styles.buttonText}>Войти</Text>
        </TouchableOpacity>
      </View>
      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.button}>
          <Text style={styles.buttonText}>Регистрация</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  screenContainer: {
    width: "100%",
    height: "100%",
    backgroundColor: COLORS.white,
    display: "flex",
    justifyContent: "flex-end",
    paddingBottom: 30,
  },
  headerTextContainer: {
    width: "100%",
    padding: 10,
  },
  headerText: { fontSize: 25, fontWeight: "bold", textAlign: "center" },
  plainTextContainer: {
    width: "100%",
    padding: 20,
  },
  plainText: { fontSize: 15, color: COLORS.gray, textAlign: "justify" },
  textInputContainer: {
    width: "100%",
    paddingHorizontal: 30,
    paddingVertical: 15,
  },
  textInput: {
    borderColor: COLORS.primaryDark,
    borderStyle: "solid",
    borderWidth: 2,
    borderRadius: 10,
    paddingHorizontal: 10,
    paddingVertical: 5,
    fontSize: 20,
  },
  buttonContainer: {
    width: "100%",
    paddingHorizontal: 30,
    paddingVertical: 15,
  },
  button: {
    backgroundColor: COLORS.primary,
    borderRadius: 30,
    paddingVertical: 10,
    paddingHorizontal: 20,
    alignSelf: "center",
  },
  buttonText: {
    color: COLORS.white,
    fontSize: 15,
    textAlign: "center",
    fontWeight: "bold",
  },
  image: { width: "100%", height: 200, resizeMode: "center" },
});

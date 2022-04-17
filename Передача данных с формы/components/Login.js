import React from "react";
import {
  View,
  Text,
  StyleSheet,
  TextInput,
  TouchableOpacity,
  Image,
  Alert,
} from "react-native";

export default function Login({ navigation }) {
  const [login, setLogin] = React.useState("");
  const [password, setPassword] = React.useState("");

  return (
    <View style={styles.screenContainer}>
      <Image source={require("../images/login.png")} style={styles.image} />
      <View style={styles.headerTextContainer}>
        <Text style={styles.headerText}>Авторизация</Text>
      </View>
      <View style={styles.plainTextContainer}>
        <Text style={styles.plainText}>
          Введите логин и пароль, который создавали ранее при регистрации
        </Text>
      </View>
      <View style={styles.textInputContainer}>
        <TextInput
          style={styles.textInput}
          placeholder={"Логин"}
          onChangeText={(inputLogin) => setLogin(inputLogin)}
        ></TextInput>
      </View>
      <View style={styles.textInputContainer}>
        <TextInput
          style={styles.textInput}
          secureTextEntry={true}
          placeholder={"Пароль"}
          onChangeText={(inputPassword) => setPassword(inputPassword)}
        ></TextInput>
      </View>
      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.button}>
          <Text
            style={styles.buttonText}
            onPress={() => {
              navigation.navigate("Welcome", {
                login: login,
                password: password,
                message: "Вы успешно авторизированы",
                image: require("../assets/images/authorized.png"),
              });
            }}
          >
            Войти
          </Text>
        </TouchableOpacity>
      </View>
      <View style={styles.buttonContainer}>
        <TouchableOpacity
          style={styles.button}
          onPress={() => {
            navigation.navigate("Register");
          }}
        >
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
    backgroundColor: "#FAF8FF",
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
  plainText: { fontSize: 15, color: "#7D7D7D", textAlign: "justify" },
  textInputContainer: {
    width: "100%",
    paddingHorizontal: 30,
    paddingVertical: 15,
  },
  textInput: {
    borderColor: "#008893",
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
    backgroundColor: "#7FD1AE",
    borderRadius: 30,
    paddingVertical: 10,
    paddingHorizontal: 20,
    alignSelf: "center",
  },
  buttonText: {
    color: "#fff",
    fontSize: 15,
    textAlign: "center",
    fontWeight: "bold",
  },
  image: { width: "100%", height: 200, resizeMode: "center" },
});

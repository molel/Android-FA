import { View, Text, StyleSheet, Image } from "react-native";

export default function Welcome({ route }) {
  return (
    <View style={styles.screenContainer}>
      <Image source={route.params.image} style={styles.image} />
      <View style={styles.headerTextContainer}>
        <Text style={styles.headerText}>{route.params.message}</Text>
      </View>
      <View>
        <View style={styles.plainTextContainer}>
          <Text style={styles.plainText}>
            Ваш логин:{"\n"}
            {route.params.login}
          </Text>
        </View>
        <View style={styles.plainTextContainer}>
          <Text style={styles.plainText}>
            Ваш пароль:{"\n"}
            {route.params.password}
          </Text>
        </View>
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
    justifyContent: "space-evenly",
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
    paddingHorizontal: 20,
    paddingVertical: 10,
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

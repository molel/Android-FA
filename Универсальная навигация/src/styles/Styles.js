import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
  headerText: { fontSize: 40, fontWeight: "bold" },
  navigationButtonText: { fontSize: 20 },
  navigationButton: {
    width: "30%",
    margin: 5,
    padding: 5,
    borderColor: "#aaa",
    borderWidth: 1,
    borderRadius: 5,
    backgroundColor: "#ccc",
    justifyContent: "center",
    alignItems: "center",
  },
  contactListItemContainer: {
    width: "100%",
    height: 100,
    display: "flex",
    flexDirection: "row",
    marginBottom: "2%",
    justifyContent: "flex-start",
    alignItems: "center",
  },
  contactListItemText: { fontSize: 30 },
  screenContainer: {
    paddingTop: "2%",
    width: "100%",
    height: "100%",
    justifyContent: "space-evenly",
    alignItems: "center",
  },
});

export default styles;

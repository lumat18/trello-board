<template>
  <div class="board">
    <div class="columns-wrapper">
      <BoardColumn
        v-for="(column, $columnIndex) in board.columns"
        :key="$columnIndex"
        :column="column"
        :columnIndex="$columnIndex"
        :board="board"
      />
    </div>
    <div class="column">
      <input
        type="text"
        v-model="newColumnName"
        placeholder="New column name"
        @keyup.enter="createColumn"
      />
    </div>
    <div class="modal" v-if="isTaskModalOpen" @click.self="closeModal">
      <router-view />
    </div>

    <AppButton type="danger">Click here</AppButton>
  </div>
</template>

<script>
import AppButton from "../components/AppButton";
import BoardColumn from "../components/BoardColumn";
import { mapState } from "vuex";

export default {
  name: "Board",
  components: { AppButton, BoardColumn },
  data() {
    return {
      newColumnName: ""
    };
  },
  computed: {
    ...mapState(["board"]),
    isTaskModalOpen() {
      return this.$route.name === "task";
    }
  },
  methods: {
    closeModal() {
      this.$router.push({ name: "board" });
    },
    createColumn() {
      this.$store.commit("CREATE_COLUMN", {
        name: this.newColumnName
      });
      this.newColumnName = "";
    }
  }
};
</script>

<style scoped>
.columns-wrapper {
  display: flex;
}

.modal {
  position: fixed;
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 999;
  background: rgba(76, 175, 80, 0.8);
  top: 0;
  left: 0;
  height: 100vh;
  width: 100vw;
}
</style>

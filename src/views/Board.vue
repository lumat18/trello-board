<template>
  <div class="board">
    <div class="columns-wrapper">
      <div v-for="(column, index) in board.columns" :key="index" class="column">
        <div class="column-name">{{ column.name }}</div>
        <div
          v-for="task in column.tasks"
          :key="task.id"
          class="task"
          @click="openModal(task)"
        >
          <span>{{ task.name }}</span>
          <p v-if="task.description">{{ task.description }}</p>
        </div>

        <input
          type="text"
          placeholder="+ Add task"
          @keyup.enter="createTask($event, column.tasks)"
        />
      </div>
    </div>
    <div class="modal" v-if="isTaskModalOpen" @click.self="closeModal">
      <router-view />
    </div>

    <AppButton type="danger">Click here</AppButton>
  </div>
</template>

<script>
import AppButton from "../components/AppButton";
import { mapState } from "vuex";

export default {
  name: "Board",
  components: { AppButton },
  computed: {
    ...mapState(["board"]),
    isTaskModalOpen() {
      return this.$route.name === "task";
    }
  },
  methods: {
    openModal(task) {
      this.$router.push({ name: "task", params: { id: task.id } });
    },
    closeModal() {
      this.$router.push({ name: "board" });
    },
    createTask(event, tasks) {
      this.$store.commit("CREATE_TASK", {
        tasks,
        name: event.target.value
      });
      event.target.value = "";
    }
  }
};
</script>

<style scoped>
.columns-wrapper {
  display: flex;
}
.column {
  border: 1px solid black;
  margin: 8px;
  padding: 4px;
  border-radius: 8px;
  width: 250px;
}
.column-name {
  font-weight: bolder;
}

.task {
  display: block;
  cursor: pointer;
  border: 1px solid black;
  border-radius: 8px;
  margin: 4px;
  padding: 4px;
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

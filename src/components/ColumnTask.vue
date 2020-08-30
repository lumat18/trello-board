<template>
  <div
    class="task"
    draggable="true"
    @dragstart="pickupTask($event, taskIndex, columnIndex)"
    @click="openModal(task)"
    @dragover.prevent
    @dragenter.prevent
    @drop.stop="moveTaskOrColumn($event, column.tasks, columnIndex, taskIndex)"
  >
    <span>{{ task.name }}</span>
    <p v-if="task.description">{{ task.description }}</p>
  </div>
</template>
<script>
export default {
  name: "ColumnTask",
  props: {
    task: {
      type: Object,
      required: true
    },
    taskIndex: {
      type: Number,
      required: true
    },
    column: {
      type: Object,
      required: true
    },
    columnIndex: {
      type: Number,
      required: true
    },
    board: {
      type: Object,
      required: true
    }
  },
  methods: {
    openModal(task) {
      this.$router.push({ name: "task", params: { id: task.id } });
    },
    pickupTask(event, taskIndex, fromColumnIndex) {
      event.dataTransfer.effectAllowed = "move";
      event.dataTransfer.dropEffect = "move";
      event.dataTransfer.setData("task-index", taskIndex);
      event.dataTransfer.setData("from-column-index", fromColumnIndex);
      event.dataTransfer.setData("type", "task");
    },
    moveTaskOrColumn(event, toTasks, toColumnIndex, toTaskIndex) {
      const type = event.dataTransfer.getData("type");
      if (type === "task") {
        this.moveTask(event, toTasks, toTaskIndex);
      } else {
        this.moveColumn(event, toColumnIndex);
      }
    },
    moveTask(event, toTasks, toTaskIndex) {
      const fromColumnIndex = event.dataTransfer.getData("from-column-index");
      const fromTasks = this.board.columns[fromColumnIndex].tasks;
      const taskIndex = event.dataTransfer.getData("task-index");

      this.$store.commit("MOVE_TASK", {
        fromTasks,
        toTasks,
        taskIndex,
        toTaskIndex
      });
    },
    moveColumn(event, toColumnIndex) {
      const fromColumnIndex = event.dataTransfer.getData("from-column-index");
      this.$store.commit("MOVE_COLUMN", { fromColumnIndex, toColumnIndex });
    }
  }
};
</script>

<style scoped>
.task {
  display: block;
  cursor: pointer;
  background-color: lightgray;
  border: 1px solid black;
  border-radius: 8px;
  margin: 4px;
  padding: 4px;
}
</style>

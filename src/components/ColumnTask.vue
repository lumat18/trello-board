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
import MovingTasksAndColumnsMixin from "../mixins/MovingTasksAndColumnsMixin";
export default {
  name: "ColumnTask",
  mixins: [MovingTasksAndColumnsMixin],
  props: {
    task: {
      type: Object,
      required: true
    },
    taskIndex: {
      type: Number,
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

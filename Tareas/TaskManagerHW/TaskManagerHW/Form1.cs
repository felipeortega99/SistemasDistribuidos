using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.ServiceProcess;
using System.Windows.Forms;

namespace TaskManagerHW
{
    public partial class Form1 : Form
    {                     
        //ProcessManager ProcessManager = new ProcessManager();
        private static List<Process> Processes { get; set; }
        private SortedSet<string> UniqueProcesses = new SortedSet<string>();
        private List<ListViewGroup> listGroup = new List<ListViewGroup>();

        public Form1()
        {            
            InitializeComponent();                       
        }      

        private void tabPage1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {                        
            UpdateListView();
            GetServices();
        }

        private void ejecutarNuevoProcesoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            using(frmRunTask frm = new frmRunTask())
            {
                if(frm.ShowDialog() == DialogResult.OK)
                {
                    UpdateListView();
                }
            }
        }

        private void terminarProcesoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            using (frmEndTask frm = new frmEndTask())
            {
                if (frm.ShowDialog() == DialogResult.OK)
                {
                    UpdateListView();
                }
            }
        }

        private void consumoDeMemoriaToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmMemory frm = new frmMemory();           
            frm.Show();                
        }

        public void UpdateListView()
        {
            int i = 0;

            listView_Process.Items.Clear();
            listView_Process.Groups.Clear();

            Processes = Process.GetProcesses().ToList();

            foreach (var process in Processes)
            {
                UniqueProcesses.Add(process.ProcessName);
            }

            foreach (string pName in UniqueProcesses)
            {                
                CreateListViewGroup(pName);
            }

            foreach (ListViewGroup group in listView_Process.Groups)
            { 
                foreach (var process in Processes)
                {
                    if (group.Header == process.ProcessName)
                    {
                        listView_Process.Items.Add(CreateListViewItem(process, listView_Process.Groups[i]));
                    }             
                }

                i++;
            }            
        }

        public ListViewItem CreateListViewItem(Process process, ListViewGroup listGroup)
        {
            string[] item =
            {
                    process.Id.ToString(),
                    process.ProcessName,
                    process.MachineName,                    
                    (process.Responding)? "Respondiendo" : "Sin responder",
                    process.MainWindowTitle
            };

            var listViewItem = new ListViewItem(item, listGroup);
            listViewItem.SubItems.Add(process.ProcessName);
            listViewItem.SubItems.Add(process.Threads.Count.ToString());

            return listViewItem;
        }        

        public void CreateListViewGroup(string processName)
        {
            ListViewGroup group = new ListViewGroup(processName);
            listView_Process.Groups.Add(group);
        }

        private void GetServices()
        {
            foreach (ServiceController service in ServiceController.GetServices())
            {               
                if (service.Status == ServiceControllerStatus.Running)
                {
                    string[] srow = {
                        service.ServiceName,
                        service.DisplayName
                    };

                    ListViewItem item = new ListViewItem(srow);
                    listView_Servicios.Items.Add(item);

                }
            };
        }  
    }
}

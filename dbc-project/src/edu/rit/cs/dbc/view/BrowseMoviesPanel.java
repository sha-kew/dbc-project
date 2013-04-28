/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.cs.dbc.view;

import edu.rit.cs.dbc.model.MovieTableModel;
import edu.rit.cs.dbc.controller.MovieTableController;
import edu.rit.cs.dbc.model.Movie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ptr5201
 */
public class BrowseMoviesPanel extends javax.swing.JPanel {

    /**
     * Creates new form BrowseMoviesPanel
     */
    public BrowseMoviesPanel() {
        initComponents();
    }
    
    public void registerController(MovieTableController movieTableController) {
        this.movieTableController = movieTableController;
        this.movieTableController.registerBrowseMoviesPanel(this);
        this.movieTableController.loadBrowseMoviesTable();
    }

    public MovieTableModel getMovieTableModel() {
        return browseMoviesTableModel;
    }
    
    /** 
     * Update the row filter regular expression from the expression in
     * the text box.
     */
    private void filterMovieResults() {
        if (filterByComboBox.getSelectedItem() != null &&
                !filterByComboBox.getSelectedItem().toString().equals("")) {
            String columnToFilter = filterByComboBox.getSelectedItem().toString();
            
            RowFilter<MovieTableModel, Object> rf;
            //If current expression doesn't parse, don't update.
            try {
                int columnIndex = Arrays.asList(MovieTableModel.MOVIE_COLUMN_NAMES).indexOf(columnToFilter);
                rf = RowFilter.regexFilter(filterByTextField.getText(), columnIndex);
            } catch (java.util.regex.PatternSyntaxException e) {
                return;
            }
            sorter.setRowFilter(rf);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upperPanel = new javax.swing.JPanel();
        moviesTableScollPane = new javax.swing.JScrollPane();
        browseMoviesTable = new javax.swing.JTable();
        filterPanel = new javax.swing.JPanel();
        filterByLabel = new javax.swing.JLabel();
        filterByComboBox = new javax.swing.JComboBox();
        filterByTextField = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        addToQueueButton = new javax.swing.JButton();

        setName("Browse Movies Screen"); // NOI18N
        setLayout(new java.awt.BorderLayout());

        browseMoviesTable.setModel(browseMoviesTableModel);
        browseMoviesTable.setRowSorter(sorter);
        browseMoviesTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        moviesTableScollPane.setViewportView(browseMoviesTable);

        filterByLabel.setText("Filter by:");

        filterByComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Title", "Year", "Genre", "Rating" }));
        filterByComboBox.setSelectedIndex(-1);
        filterByComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterByComboBoxActionPerformed(evt);
            }
        });

        filterByTextField.getDocument().addDocumentListener(
            new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    filterMovieResults();
                }
                public void insertUpdate(DocumentEvent e) {
                    filterMovieResults();
                }
                public void removeUpdate(DocumentEvent e) {
                    filterMovieResults();
                }
            }
        );

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filterByLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterByTextField)
                .addContainerGap())
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterByComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterByTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout upperPanelLayout = new javax.swing.GroupLayout(upperPanel);
        upperPanel.setLayout(upperPanelLayout);
        upperPanelLayout.setHorizontalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(filterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, upperPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(moviesTableScollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );
        upperPanelLayout.setVerticalGroup(
            upperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(upperPanelLayout.createSequentialGroup()
                .addComponent(filterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moviesTableScollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(upperPanel, java.awt.BorderLayout.CENTER);

        addToQueueButton.setText("Add to Queue");
        addToQueueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToQueueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addToQueueButton)
                .addContainerGap(372, Short.MAX_VALUE))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addToQueueButton)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        add(buttonPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void filterByComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterByComboBoxActionPerformed
        filterMovieResults();
    }//GEN-LAST:event_filterByComboBoxActionPerformed

    private void addToQueueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToQueueButtonActionPerformed
        int selection[] = browseMoviesTable.getSelectedRows();
        for (int selectionIndex = 0; selectionIndex < selection.length; selectionIndex++) {
            selection[selectionIndex] = browseMoviesTable.convertRowIndexToModel(selection[selectionIndex]);
        }
        Collection<Movie> moviesSelected = new ArrayList<>();
        for (int selectionIndex = 0; selectionIndex < selection.length; selectionIndex++) {
            Movie m = browseMoviesTableModel.getMovieAt(selection[selectionIndex]);
            if (m != null) {
                moviesSelected.add(m);
            }
        }
        if (!moviesSelected.isEmpty()) {
            movieTableController.addMoviesToQueue(moviesSelected);
        }
    }//GEN-LAST:event_addToQueueButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToQueueButton;
    private javax.swing.JTable browseMoviesTable;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JComboBox filterByComboBox;
    private javax.swing.JLabel filterByLabel;
    private javax.swing.JTextField filterByTextField;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JScrollPane moviesTableScollPane;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables

    private MovieTableModel browseMoviesTableModel = new MovieTableModel();
    private TableRowSorter<MovieTableModel> sorter = new TableRowSorter<>(browseMoviesTableModel);
    private MovieTableController movieTableController;

}
